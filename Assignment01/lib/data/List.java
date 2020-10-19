class List{
	Bed bed;
	Chair chair;
	public List(Bed bed, Chair chair){
		this.bed=bed;
		this.chair=chair;
	}
	public void getList(){
		System.out.println("Chair dimensions: "+chair.length+"*"+chair.breadth+"*"+chair.height);
		System.out.println("Bed dimensions: "+bed.length+"*"+bed.breadth+"*"+bed.height);
	}
}