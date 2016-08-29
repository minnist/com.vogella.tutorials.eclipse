import javax.annotation.PostConstruct;
import org.eclipse.swt.widgets.Composite;

// more code

@PostConstruct
public void createControls(Composite parent) {
	System.out.println(this.getClass().getSimpleName()
	+ " @PostConstruct method called.");
}

