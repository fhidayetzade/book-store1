package springdata.bookstore1.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CategoryResponse {

    private Integer id;
    private String name;
    private List<String> bookNames;
}
