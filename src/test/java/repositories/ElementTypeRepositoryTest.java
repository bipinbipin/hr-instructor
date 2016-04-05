package repositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Element;
import com.astontech.hr.domain.ElementType;
import com.astontech.hr.repositories.ElementTypeRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Bipin on 3/25/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class ElementTypeRepositoryTest {

    @Autowired
    private ElementTypeRepository elementTypeRepository;
    ElementType elementType = new ElementType();

    //this method is run before tests are run.
    public void setUp() {

        List<Element> elementList = new ArrayList<Element>();

        elementList.add(new Element("Samsung"));
        elementList.add(new Element("Acer"));
        elementList.add(new Element("Dell"));
        elementList.add(new Element("AOP"));
        elementList.add(new Element("View Sonic"));

        elementType.setElementList(elementList);

    }

    @Test
    public void testSaveElementType() {
//        ElementType elementType = buildElementType();

        assertNull(elementType.getId());
        elementTypeRepository.save(elementType);
        assertNotNull(elementType.getId());

        ElementType fetchedElementType = elementTypeRepository.findOne(elementType.getId());

        assertEquals(fetchedElementType.getId(), elementType.getId());
    }

    @Test
    public void testFindByElementTypeName() {
//        ElementType elementType = buildElementType();
        elementType.setElementTypeName("Laptop");

        elementTypeRepository.save(elementType);

        ElementType foundElementType = elementTypeRepository.findByElementTypeName("Laptop");
        assertEquals("Laptop", foundElementType.getElementTypeName());
        assertNotEquals("Phones", foundElementType.getElementTypeName());




    }
}
