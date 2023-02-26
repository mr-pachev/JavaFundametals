package FinalExams;

import java.util.*;

public class HeroesOfCodeAndLogic7_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Integer>> heroesMap = new LinkedHashMap<>();

        for (int hero = 0; hero < n; hero++) {
            String heroData = scanner.nextLine();
            String name = heroData.split(" ")[0];
            int healPoints = Integer.parseInt(heroData.split(" ")[1]);
            int manaPoints = Integer.parseInt(heroData.split(" ")[2]);
            List<Integer> heroDataList = new ArrayList<>();

            heroDataList.add(healPoints);
            heroDataList.add(manaPoints);
            heroesMap.put(name, heroDataList);
        }

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String command = input.split("\\s-\\s")[0];

            switch (command) {
                case "CastSpell": {
                    String heroName = input.split("\\s-\\s")[1];
                    int neededMP = Integer.parseInt(input.split("\\s-\\s")[2]);
                    String spellName = input.split("\\s-\\s")[3];

                    List<Integer> heroList = heroesMap.get(heroName);
                    int currentMP = heroList.get(1);

                    if (currentMP - neededMP < 0) {
                        System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                    } else {
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName, currentMP - neededMP);
                        heroList.set(1, currentMP - neededMP);
                        heroesMap.put(heroName, heroList);
                    }
                    break;
                }
                case "TakeDamage": {
                    String heroName = input.split("\\s-\\s")[1];
                    int damage = Integer.parseInt(input.split("\\s-\\s")[2]);
                    String attacker = input.split("\\s-\\s")[3];

                    List<Integer> heroList = heroesMap.get(heroName);
                    int currentHP = heroList.get(0);

                    if (currentHP - damage <= 0) {
                        heroesMap.remove(heroName);
                        System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                    } else {
                        heroList.set(0, currentHP - damage);
                        heroesMap.put(heroName, heroList);
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, damage, attacker, currentHP - damage);
                    }
                    break;
                }
                case "Recharge": {
                    String heroName = input.split("\\s-\\s")[1];
                    int amountMP = Integer.parseInt(input.split("\\s-\\s")[2]);

                    List<Integer> heroList = heroesMap.get(heroName);
                    int currentMP = heroList.get(1);
                    int useMP = amountMP;

                    if (currentMP + amountMP > 200) {
                        heroList.set(1, 200);
                        useMP = 200 - currentMP;
                    } else {
                        currentMP += amountMP;
                        heroList.set(1, currentMP);
                    }
                    System.out.printf("%s recharged for %d MP!%n", heroName, useMP);
                    heroesMap.put(heroName, heroList);
                    break;
                }
                case "Heal": {
                    String heroName = input.split("\\s-\\s")[1];
                    int amountHP = Integer.parseInt(input.split("\\s-\\s")[2]);

                    List<Integer> heroList = heroesMap.get(heroName);
                    int currentHP = heroList.get(0);

                    int usedHP = amountHP;

                    if (currentHP + amountHP > 100) {
                        heroList.set(0, 100);
                        usedHP = 100 - currentHP;
                    } else {
                        currentHP += amountHP;
                        heroList.set(0, currentHP);
                    }
                    System.out.printf("%s healed for %d HP!%n", heroName, usedHP);
                    heroesMap.put(heroName, heroList);
                    break;
                }
            }

            input = scanner.nextLine();
        }
        for (Map.Entry<String, List<Integer>> entry : heroesMap.entrySet()) {
            System.out.println(entry.getKey());

            for (int i = 0; i < entry.getValue().size(); i++) {
                if (i == 0) {
                    System.out.printf(" HP : %d%n", entry.getValue().get(0));
                } else if (i == 1) {
                    System.out.printf(" HM : %d%n", entry.getValue().get(1));
                }
            }
        }
    }
}
