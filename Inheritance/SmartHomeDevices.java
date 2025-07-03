class Devices{ //super class
	int deviceId;
	String status;
	Devices(int deviceId,String status){
		this.deviceId= deviceId;
		this.status = status;
	}
	
}

class Thermostat extends Devices{
	int temperatureSetting;
	Thermostat(int deviceId,String status,int temperatureSetting ){
		super(deviceId,status);
		this.temperatureSetting= temperatureSetting;
	}
	void displayStatus() {
		System.out.println("The device id:"+deviceId);
		System.out.println("The device is:"+status);
		System.out.println("The device temperatureSetting :"+temperatureSetting);
	}
}




public class SmartHomeDevices {


	public static void main(String[] args) {
		Thermostat thermostat = new Thermostat(2,"not working",20);
		
		thermostat.displayStatus();
		
		
	}

}