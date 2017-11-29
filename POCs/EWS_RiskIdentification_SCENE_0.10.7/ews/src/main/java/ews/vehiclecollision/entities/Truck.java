package ews.vehiclecollision.entities;

public class Truck {
	private int id;
    private String name;
    private int latitude;
    private int longitude;
    private int speed;
    private int acceleration;
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLatitude() {
		return latitude;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	public int getLongitude() {
		return longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(int acceleration) {
		this.acceleration = acceleration;
	}

    public int getId() {
        return id;
    }

    public Truck setId(int id) {
        this.id = id;
        
        return this;
    }
}
