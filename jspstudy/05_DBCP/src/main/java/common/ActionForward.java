package common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor			// public actionforwartd(string view, boolean isredirect) { this.view = view this.redirect = isredirect;}

public class ActionForward {	// 어디로 어떻게 갈꺼냐
	private String view;			// getView(), setView()
	private boolean isRedirect;		// isRedirect(), setRedirect()
}
