import java.util.*;

public class MaterialCollection {

    private ArrayList<Material> materials = new ArrayList<>();
    private int capacity;

    public MaterialCollection() {
        this.capacity = 20;
    }

    public MaterialCollection(int capacity) {
        this.capacity = capacity;
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void addMaterial(Material material) {
    	if(materials.size() != capacity) {
    		materials.add(material);
    	}
    }
}