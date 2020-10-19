public class FurnitureApp{
	public static void main(String []args){
		Chair chair = new Chair(10,12,13);
		Bed bed = new Bed(10,12,14);
		List list = new List(bed,chair);
		list.getList();
	}
}