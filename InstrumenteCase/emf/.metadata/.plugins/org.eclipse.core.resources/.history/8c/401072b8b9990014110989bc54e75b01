public class Main {
    public static void main(String[] args) {
    	Inspector i = new Inspector();
    	i.nume = "Inspector";
    		
    	Mormant m1 = new Mormant();
    	m1.idMormant = 1;
   
    	Detinator det1 = new Detinator();
    	det1.idDetinator = 1;
    	det1.nume = "Popescu";
    	det1.chitanta = "chitanta1";
    	det1.addMorminte(m1);
    	System.out.println(det1.getNume() + "| Mormant: " + det1.getMorminte().toArray()[0].toString());

    	Decedat d1 = new Decedat();
    	d1.idDecedat = 0;
    	d1.nume = "Pop";
    	d1.prenume = "Vasile";
    	d1.setMormant(m1);
    
    	Decedat d2 = new Decedat();
    	d2.idDecedat = 1;
    	d2.nume = "Pop";
    	d2.prenume = "Ana";
    	d2.setMormant(m1);
    	System.out.println(d1.getNume() +" "+ d1.getPrenume() + "| Mormant: " + d1.getMormant().idMormant);
    	System.out.println(d2.getNume() +" "+ d2.getPrenume() + "| Mormant: " + d2.getMormant().idMormant);
    
    	i.addDetinatori(det1);
    	i.addDecedati(d1);
    	i.addMorminte(m1);
    	System.out.println(i.getNume() + i.getDecedati() + i.getDetinatori() + i.getMorminte());
    	
    }
}