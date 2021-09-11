package entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Color {

    @Getter @Setter String name;
    @Getter @Setter String hexValue;
}
