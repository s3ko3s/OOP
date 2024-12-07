package L5.model.client;

import lombok.*;
import L5.model.Specialize;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Client {
    private String FIO;
    private Specialize direction;
    private LocalDate birthday;
    private LocalDate workout;

}
