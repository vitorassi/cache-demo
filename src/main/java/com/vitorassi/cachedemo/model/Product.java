package com.vitorassi.cachedemo.model;

import jdk.jshell.Snippet;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product implements Serializable {

    private Long id;
    private String name;

}
