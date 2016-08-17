package repositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Element;
import com.astontech.hr.domain.Employee;
import com.astontech.hr.repositories.ElementRepository;
import com.astontech.hr.repositories.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by Bipin on 3/25/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class ElementRepositoryTest {

    @Autowired
    private ElementRepository elementRepository;

    @Test
    public void testSaveElement() {
        //setup element
        Element element = new Element();
        element.setElementName("Phone");

        //save element, verify has ID value after save
        assertNull(element.getId());  //null before save
        elementRepository.save(element);
        assertNotNull(element.getId());

        //fetch
        Element fetchedElement = elementRepository.findOne(element.getId());
        assertNotNull(fetchedElement);
        assertEquals(element.getId(), fetchedElement.getId());

        //update
        fetchedElement.setElementName("Email");
        elementRepository.save(fetchedElement);

        Element fetchedUpdatedElement = elementRepository.findOne(fetchedElement.getId());
        assertEquals(fetchedElement.getId(), fetchedUpdatedElement.getId());

    }

    @Test
    public void testSaveElementList() {

        List<Element> elementList = new ArrayList<Element>();

        elementList.add(new Element("Samsung"));
        elementList.add(new Element("Acer"));
        elementList.add(new Element("Dell"));
        elementList.add(new Element("AOP"));
        elementList.add(new Element("View Sonic"));

        elementRepository.save(elementList);


    }


    @Test
    public void testFindByElementName() {
        elementRepository.save(new Element("Dell"));

        List<Element> elementList = elementRepository.findAllByElementName("Dell");

        //assertEquals(,elementList.size());
        assertEquals("dell", elementList.get(0).getElementName());
    }
}
