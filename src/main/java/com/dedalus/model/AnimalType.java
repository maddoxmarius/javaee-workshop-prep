/*             C O P Y R I G H T  (c) 2024
 *
 *                     DEDALUS SPA
 *
 *                 All Rights Reserved
 *
 *
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF
 *                     DEDALUS SPA
 *  The copyright notice above does not evidence any
 * actual or intended publication of such source code.
 */
package com.dedalus.model;

import lombok.Getter;

@Getter
public enum AnimalType {
    CAT("cat"),
    DOG("dog"),
    FISH("fish"),
    BIRD("bird"),
    REPTILE("reptile"),
    RODENT("rodent"),
    AMPHIBIAN("amphibian"),
    INSECT("insect"),
    ARACHNID("arachnid"),
    CRUSTACEAN("crustacean"),
    MOLLUSK("mollusk"),
    OTHER("other");

    private final String type;

    AnimalType(String type) {
        this.type = type;
    }
}
