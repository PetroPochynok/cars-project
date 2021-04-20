package org.project.cars.dao;

import org.project.cars.entity.Role;

public interface RoleDAO {
    Role findRoleByName(String roleName);
}
