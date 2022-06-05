package mybatis;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter		// Builder 패턴을 이용해서 ProductDTO 생성
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
	private Long productNo;
	private String name;
	private Integer price;
	private String image;
}
