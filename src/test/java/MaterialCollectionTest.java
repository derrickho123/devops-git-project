import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author Derrick
 *
 */
class MaterialCollectionTest {

	private MaterialCollection mc;
	private Material m1;
	private Material m2;
	private Material m3;
	private Material m4;
	private final int MATERIAL_COLLECTION_SIZE = 4;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		mc = new MaterialCollection();
		m1 = new Material("English","This is good","English originated from English countries","https://en.wikipedia.org/wiki/English_language");
		m2 = new Material("Chinese","This is good","Chinese originated from Chinese countries","https://en.wikipedia.org/wiki/Chinese_language");
		m3 = new Material("Maths","This is good","Math originated from Eastern countries","https://en.wikipedia.org/wiki/Mathematics");
		m4 = new Material("Science","This is good","Science originated from many countries","https://en.wikipedia.org/wiki/Science");
		mc.addMaterial(m1);
		mc.addMaterial(m2);
		mc.addMaterial(m3);
		mc.addMaterial(m4);
	}


	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link MaterialCollection#getMaterials()}.
	 */
	@Test
	void testGetMaterials() {
		List<Material> testMc = mc.getMaterials();
		assertEquals(testMc.size(), MATERIAL_COLLECTION_SIZE);
	}

	/**
	 * Test method for {@link MaterialCollection#addMaterial(Material)}.
	 */
	@Test
	void testAddMaterial() {
		List<Material> testMc = mc.getMaterials();
		assertEquals(testMc.size(), MATERIAL_COLLECTION_SIZE);
		mc.addMaterial(m1);
		assertEquals(mc.getMaterials().size(), MATERIAL_COLLECTION_SIZE+1);
	}
}
