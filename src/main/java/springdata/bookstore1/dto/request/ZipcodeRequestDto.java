package springdata.bookstore1.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ZipcodeRequestDto {

    private Integer id;
    private String name;
    private Integer cityId;
    private String x;
}
