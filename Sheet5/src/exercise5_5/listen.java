package exercise5_5;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;


class listen implements DocumentListener{

	public void insertUpdate(DocumentEvent e) {
		updateLog(e, "inserted into");
	}
	public void removeUpdate(DocumentEvent e) {
		updateLog(e, "removed from");
	}
	public void changedUpdate(DocumentEvent e) {
		//Plain text components do not fire these events
	}

	public void updateLog(DocumentEvent e, String action) {
		Document doc = (Document)e.getDocument();
		//right.displayArea.append(doc);

	}
}


