class FurnitureApp{
    public static void main(String []args){

        //Bed bed=new Bed();

        //you must specify a package qualified class name to use class
        furnitures.bedroom.Bed bed=new furnitures.bedroom.Bed(); 
	furnitures.livingroom.Chair chair=new furnitures.livingroom.Chair();
	furnitures.livingroom.Table table=new furnitures.livingroom.Table(); 
	furnitures.office.Chair officeChair=new furnitures.office.Chair();
	furnitures.office.Table officeTable=new furnitures.office.Table();  
        System.out.printf("The price of %s is %d\n",bed, bed.price());
	System.out.printf("The price of %s is %d\n",chair, chair.price());
	System.out.printf("The price of %s is %d\n",table, table.price());
	System.out.printf("The price of %s is %d\n",officeChair, officeChair.price());
	System.out.printf("The price of %s is %d\n",officeTable, officeTable.price());
    }
} 