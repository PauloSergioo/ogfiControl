package com.ogficontrol.demo.services.validation;

import com.ogficontrol.demo.services.exceptions.EmptyListException;
import com.ogficontrol.demo.services.exceptions.InvalidProjectIdException;

import java.util.List;

public class ProjectIdValidation {

    public static void validateProjectId(Long projectId) {

        if (projectId == null || projectId < 1) {
            throw new InvalidProjectIdException("ID do projeto inválido: " + projectId);
        }
    }

    public static void validateNonEmptyList(List<?> list, String message) {
        if (list == null || list.isEmpty()) {
            throw new EmptyListException(message);
        }
    }
}
