package com.example.library_management_system.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class StandedResponce {
    private int code ;
    private String messaage ;
    private Object Data ;
}
