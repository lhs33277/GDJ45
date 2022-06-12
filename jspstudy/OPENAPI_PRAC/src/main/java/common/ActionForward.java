package common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActionForward {
	private String view;			// 어디로 갈꺼냐
	private boolean isRedirect;		// 어떻게 갈꺼냐
}
