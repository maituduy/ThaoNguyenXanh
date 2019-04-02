import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
	private Model model;
	private View view;
	
	Controller(Model model, View view) {
		this.model = model;
		this.view = view;
		
		view.addButtonEvent(new MyActionListener());
	}
	
	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int[][] res = model.getNextGen(view.getVals());
			view.update(res);
		}
		
	}
}
