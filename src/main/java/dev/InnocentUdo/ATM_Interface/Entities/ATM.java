package dev.InnocentUdo.ATM_Interface.Entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ATM {
    private double balance;
    private double depositAmount;
    private double withdrawAmount;

}
