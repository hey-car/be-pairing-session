import com.heycar.pairingsession.PairingServiceApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {PairingServiceApplication.class})
@AutoConfigureMockMvc
public class ListingsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldDoStuff() throws Exception {

    }
}
