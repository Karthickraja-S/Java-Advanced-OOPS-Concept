import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CyclicDependencyChecker {
    static void main() {
        // input :
        // A : B,C,D
        // B : C , D
        // C : A
        // Output : true because c needs a which results in cycle.

        Map<String, List<String>> dependencyMap = new HashMap<>();
        dependencyMap.put("A",List.of("B","C","D"));
        dependencyMap.put("B",List.of("C","D"));
    //    dependencyMap.put("C",List.of("X"));
        dependencyMap.put("X",List.of("A"));

        System.out.println(checkCycle(dependencyMap));
    }

    private static boolean checkCycle(Map<String, List<String>> dependencyMap) {
        for(String key : dependencyMap.keySet()) {
            if(helper(key , dependencyMap,new ArrayList<>())) {
                System.out.println("Here for key : "+key);
                return true;
            }
        }
        return false;
    }

    private static boolean helper(String key, Map<String, List<String>> dependencyMap, List<String> visited) {
        if(!dependencyMap.containsKey(key)) {
            // no dependency
            return false;
        }
        if(visited.contains(key)) {
            // cycle found
            return true;
        }
        visited.add(key);
        List<String> otherDep = dependencyMap.get(key);
        for(String dep : otherDep){
            return helper(dep,dependencyMap,visited);
        }
        visited.remove(key);
        return false;
    }
}
