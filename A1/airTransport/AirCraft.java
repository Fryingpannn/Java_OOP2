package airTransport;


public class AirCraft 
{
	private AirType deviceType;
	private MaintainType timeType;
	
	public enum AirType
	{
		HELICOPTER,
		AIRLINE,
		BALLOON,
		GLIDER;
	}
	
	public enum MaintainType
	{
		WEEKLY,
		MONTHLY,
		YEARLY;
	}
}
