import java.util.*;

class Person {
  public Integer skill;
  public Integer luck;
  public Double quality;
  public Integer id;

  public Person(Integer id) {
    Random rand = new Random();
    this.id = id;
    skill = 1 + rand.nextInt(100);
    luck = 1 + rand.nextInt(100);
    quality = (skill * 0.95) + (luck * 0.05);
  }
}

class Main {
  public static void main(String[] args) {
    List<Integer> luckOfTopQualityPeople = new ArrayList<>();

    for (int j = 0; j < 1000; j++) {
      List<Person> people = new ArrayList<Person>();

      for (int i = 0; i < 18300; i++) {
        people.add(new Person(i));
      }

      Comparator<Person> compareByQuality = (Person o1, Person o2) -> o1.quality.compareTo(o2.quality);
      Collections.sort(people, compareByQuality.reversed());

      for (int i = 0; i < 11; i++) {
        luckOfTopQualityPeople.add(people.get(i).luck);
      }
    }

    Double averageLuck = luckOfTopQualityPeople.stream().mapToInt(val -> val).average().orElse(0.0);
    System.out.println(averageLuck);
  }
}