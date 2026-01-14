class Pair{
	String key;
	int value;
	Pair(String key , int value){
		this.key = key;
		this.value = value;
	}
}



public class CustomHashMap {
	static Pair obj = new Pair(null,-1);
	Pair[] arr = new Pair[10];
	static int size = 0;
	CustomHashMap() {
		for(int i = 0;i<10;i++) {
			arr[i] = obj;
		}
	}
	
	public void resize() {
		if(size > arr.length) {
			Pair[] newArr = new Pair[arr.length*2];
			for(int i = 0;i<arr.length;i++) {
				newArr[i] = arr[i];
			}
			for(int i = arr.length;i<newArr.length;i++) {
				newArr[i] = obj;
			}
			arr = newArr;
		}
		
	}
	
	public void put(String key , int value) {
		size++;
		resize();
		int idx = size-1;
		boolean checkKey = false;
		 a:for(int i =0;i<size;i++) {//label break for using nested loop
			if(arr[i].key == key ) {
				arr[i].value = value;
				checkKey = true;
				 break a;
			}
		}
		if(!checkKey ) {
			Pair newObj = new Pair(key,value);
			arr[idx] = newObj;
		}
	}
	
	public void getValueByKey(String key) {
		boolean keyExist = false;
		for(int i = 0;i<size;i++) {
			if(arr[i].key == key) {
				System.out.println(arr[i].value);
				keyExist = true;
				break;
			}
		}	
		if(!keyExist) {
			System.out.println("Key doesn't exist");
		}
	}
	
	public void containsKey(String key) {
		boolean keyExist = false;
		for(int i =0;i<size;i++) {
			if(arr[i].key == key) {
				System.out.println("True , Key exist");
				keyExist = true;
				break;
			}
		}
		if(!keyExist) {
			System.out.println("False, Key doesn't exist");
		}
	}
	
	public void remove(String key) {
		boolean keyExist = false;
		int tempSize = size;
		size--;
		Pair[] newArr  = new Pair[size]; 
		for(int i =0;i<tempSize;i++) {
			if(arr[i].key == key) {
				arr[i].key = null;
				arr[i].value = -1;
				keyExist = true;
				break;
			}			
		}
		int idx = 0;
		for(int i =0;i<tempSize;i++) {
			if(arr[i].value != -1) {
				newArr[idx] = arr[i];
				idx++;
			}
		}
		arr = newArr;
		if(!keyExist) {
			System.out.println("Key doesn't exist");
		}
		
	}
	
	
	public void getAllKeyValuePair() {
		for(int i =0;i<size;i++) {
			System.out.println(arr[i].key +"->"+ arr[i].value);
		}
	}
	
	public static void main(String[] args) {
		CustomHashMap map = new CustomHashMap();
		map.put("Apple", 20);
		map.put("Orange",10);
		map.put("Mango", 30);
		map.put("Grapes",40);
		map.getAllKeyValuePair();
		map.getValueByKey("Grapes");
		map.containsKey("Orange");
		map.remove("Mango");
		map.containsKey("Mango");
		map.getAllKeyValuePair();
		
	}
	
}