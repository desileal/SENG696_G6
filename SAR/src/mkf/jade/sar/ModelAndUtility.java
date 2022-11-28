package mkf.jade.sar;

import java.util.ArrayList;
import java.util.function.Consumer;

public class ModelAndUtility {

	private class RequestModel {
		
		public RequestInfoModel requestInfo;
		public ArrayList<TaskModel> requestTasks;
	}
	
	class RequestInfoModel {
		public int requestID;
		public String softwareName;
		public String departmentName;
		public int numberOfUsers;
		public double softwareCost;
		public String businessReason;
		public InformationType informationType;
		public String requestorName;
		public String requestorEmail;
		public String vendorName;
		public String vendorEmail;
		public String comments;
		
		public RequestInfoModel()
		{
			
		}
	}
	
	private class TaskModel {
		private int taskID;
		public RequestInfoModel requestInfo;
		public String teamName;
		public String teamContact;
		public ArrayList<TaskItemModel> taskItems;
		public boolean isComplete;
		
	}
	
	public class TaskItemModel {
		public int taskItemID;
		public String taskItemName;
		public boolean isComplete;
		
	}
	
	public class Event<T> {
		
		public ArrayList<Consumer<T>> subscribers;
		
		public void addSubscriber(Consumer<T> subscriber) 
		{
			subscribers.add(subscriber);
		}
		
		public void removeSubscriber(Consumer<T> subscriber) 
		{
			for (int i = 0; i < subscribers.size(); i++) 
			{
				if (subscribers.get(i) == subscriber) 
				{
					subscribers.remove(i);
				}
			}
		}
		
		public void invoke(T t) 
		{
			
			for(int i = 0; i < subscribers.size(); i++)
			{
				subscribers.get(i).accept(t);
			}
		}
	}
	
	public enum InformationType {
		LEVEL1, LEVEL2, LEVEL3, LEVEL4;
	}
	
	
	
}
