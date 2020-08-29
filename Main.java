import java.util.*;

class Person {
  public Integer skill;
  public Integer luck;
  public Double quality;
  public Integer id;

  public Person(Integer id){
    Random rand = new Random();
    this.id = id;
    skill = rand.nextInt(100);
    luck = rand.nextInt(100);
    quality = (skill * 0.95) + (luck * 0.05);
  }
}

class Main {
  public static void main(String[] args) {
    List<Person> people = new ArrayList<Person>();
    for (int i = 0; i < 100000; i++){
      Person x = new Person(i);
      people.add(x);
      // System.out.println(x.id + ": " + x.skill + " " + x.luck + " " + x.quality);
    }

    System.out.println("\nTop 10 by skill");
    Comparator<Person> compareBySkill = (Person o1, Person o2) -> o1.skill.compareTo(o2.skill);
    Collections.sort(people, compareBySkill.reversed());
    for (int i = 0; i < 10; i++){
      Person x = people.get(i);
      System.out.println(x.id + ": " + x.skill + " " + x.luck + " " + x.quality);
    }

    System.out.println("\nTop 10 by luck");
    Comparator<Person> compareByLuck = (Person o1, Person o2) -> o1.luck.compareTo(o2.luck);
    Collections.sort(people, compareByLuck.reversed());
    for (int i = 0; i < 10; i++){
      Person x = people.get(i);
      System.out.println(x.id + ": " + x.skill + " " + x.luck + " " + x.quality);
    }

    System.out.println("\nTop 10 by overall quality");
    Comparator<Person> compareByQuality = (Person o1, Person o2) -> o1.quality.compareTo(o2.quality);
    Collections.sort(people, compareByQuality.reversed());
    for (int i = 0; i < 10; i++){
      Person x = people.get(i);
      System.out.println(x.id + ": " + x.skill + " " + x.luck + " " + x.quality);
    }
  }
}