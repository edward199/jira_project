import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@ComponentScan
@Configuration
public class Main {
	
	public static void main(String[] args)
	{
		System.out.println("It's working");
	}
	
}
