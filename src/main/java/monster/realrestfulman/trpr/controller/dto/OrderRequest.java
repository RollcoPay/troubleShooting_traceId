package monster.realrestfulman.trpr.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Robin on 2023/12/13.
 * Description :
 */
@Getter
public class OrderRequest {
    @NotEmpty
    private String productName;
    @NotEmpty
    private Integer amount;
}
