package api.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class UpdateUserRequest {
    private String name;
    private String job;
}
