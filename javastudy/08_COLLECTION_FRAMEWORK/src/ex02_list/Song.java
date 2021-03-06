package ex02_list;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString

public class Song {
	private String title;
	private String genre;
	
	
	// removeSongByObject 메소드에서 사용
	@Override
	public boolean equals(Object obj) {
		Song song = (Song)obj;	// Object 타입의 obj를 song으로 강제변환
		return title.equals(song.title) && genre.equals(song.genre);
	}


	

}
