import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class Bean {


	private boolean start = true;

	public void message() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Mensagem com ajax", ""));
		start = false;
	}

	public boolean isStart() {
		return start;
	}

	public void setStart(boolean start) {
		this.start = start;
	}

}
