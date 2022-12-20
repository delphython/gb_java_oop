import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    static List<Person> personList;
    

    public FamilyTree(){
        personList = new ArrayList();
    }


    public void addPerson(Person person){
        personList.add(person);
    }

    
    private static boolean isNull(Object obj) {
        return obj == null;
    }
    

    public static void printTree(List<Person> pList){
        for (int i = 0; i < pList.size(); i++) {
            System.out.println("Имя: " + pList.get(i).getName());
            
            String mother = !isNull(pList.get(i).getMother()) 
                ? pList.get(i).getMother().getName() 
                : "нет мамы";  
            System.out.println("\tМама: " + mother);

            String father = !isNull(pList.get(i).getFather()) 
                ? pList.get(i).getFather().getName() 
                : "нет папы";  
            System.out.println("\tПапа: " + father);

            String sister = !isNull(pList.get(i).getSister()) 
                ? pList.get(i).getSister().getName() 
                : "нет сестры";  
            System.out.println("\tСестра: " + sister);

            String brother = !isNull(pList.get(i).getBrother()) 
                ? pList.get(i).getBrother().getName() 
                : "нет брата";  
            System.out.println("\tБрат: " + brother);
        }
    }


    public static void searchTree(String name, List<Person> pList){
        boolean isExists = false;
        
        for (int i = 0; i < pList.size(); i++) {
            if (pList.get(i).getName().compareToIgnoreCase(name) == 0) {
                isExists = true;
                break;
            }
        }
        
        if (isExists) System.out.printf("Человек с именем %s есть в списке.\n", name);
        else System.out.printf("Человек с именем %s отстутствует в списке.\n", name);
    }

    
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        
        Person vanya = new Person(
            "Иван Иванов",
            null,
            null,
            null,
            null
        );
        Person tanya = new Person(
            "Татьяна Татьянова",
            null,
            null,
            null,
            null
        );
        Person lena = new Person(
            "Елена Еленова",
            null,
            null,
            null,
            null
        );
        Person sanya = new Person(
            "Александр Александров",
            null,
            null,
            null,
            null
        );

        sanya.setParents(vanya, tanya);
        lena.setParents(vanya, tanya);

        lena.setBrother(sanya);
        sanya.setSister (lena);

        familyTree.addPerson(vanya);
        familyTree.addPerson(tanya);
        familyTree.addPerson(lena);
        familyTree.addPerson(sanya);

        printTree(personList);
        
        searchTree("Татьяна Татьянова", personList);
        searchTree("Татьяна Иванова", personList);
    }
}

class Person {
	private String name;
    private Person mother;
	private Person father;
	private Person sister;
    private Person brother;
 

	public Person(
            String name,
            Person mother,
            Person father,
            Person sister,
            Person brother) {
		this.name = name;
        this.mother = mother;
        this.father = father;
        this.sister = sister;
        this.brother = brother;
	}

    public void setParents(Person mother, Person father) {
        this.father = father;
        this.mother = mother;
    }


    public void setBrother(Person brother) {
        this.brother = brother;
    }

    public void setSister(Person sister) {
        this.sister = sister;
    }


	public String getName() {
		return name;
	}


	public Person getMother() {
		return mother;
	}


	public Person getFather() {
		return father;
	}


    public Person getSister() {
		return sister;
	}
    

	public Person getBrother() {
		return brother;
	}
}