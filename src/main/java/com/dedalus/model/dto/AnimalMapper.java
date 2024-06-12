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
package com.dedalus.model.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.dedalus.model.AnimalEntity;

@Mapper
public interface AnimalMapper {

    @Mapping(target = "animalType", source = "type")
    AnimalDto toDetails(AnimalEntity entity);

    @Mapping(target = "animalType", source = "type")
    @Mapping(target = "comment", ignore = true)
    @Mapping(target = "isAvailable", ignore = true)
    AnimalDto toSummary(AnimalEntity entity);

    @Mapping(target = "type", source = "animalType")
    AnimalEntity toEntity(AnimalDto dto);
}
