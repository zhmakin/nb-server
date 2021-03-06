package org.neighbor.server.service.impl;

import org.neighbor.api.AccountUrn;
import org.neighbor.api.GeneralResponse;
import org.neighbor.api.UserUrn;
import org.neighbor.api.dtos.CreateUserRequest;
import org.neighbor.api.dtos.UserDto;
import org.neighbor.server.entity.NeighborUserEntity;
import org.neighbor.server.mappers.NeighborUserToUserDto;
import org.neighbor.server.repository.UserRepository;
import org.neighbor.server.service.RoleService;
import org.neighbor.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private NeighborUserToUserDto neighborUserToUserDto;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

//    @Override
//    public NeighborUser createDefaultUserForAccountId(Long accountId) {
//        NeighborUser user = userRepository.save(defaultForAccount(accountId));
//        roleService.createDefaultRoleForUserId(user.getId());
//        return user;
//    }


    @Override
    public GeneralResponse create(CreateUserRequest request, AccountUrn accountUrn) {

        return null;
    }

    @Override
    public UserDto getUserByUrn(String urn) {
        UserUrn userUrn = new UserUrn(urn);
        Optional<NeighborUserEntity> neighborUser = userRepository.findByLogin(userUrn.getLogin());
        if (neighborUser.isPresent()) {
            UserDto userDto = neighborUserToUserDto.userToUserDto(neighborUser.get());
            return userDto;
        }
        return null;
    }

    @Override
    public List<UserDto> getUsersByFilter(Object filter) {
        return new ArrayList<>();
    }

    @Override
    public boolean updateUser(NeighborUserEntity user) {
        return false;
    }

    @Override
    public Optional<NeighborUserEntity> getUserByLoginAndPin(String login, String pin) {
        return userRepository.findUserByLoginAndPinCode(login, pin);
    }

    @Override
    public Optional<NeighborUserEntity> getUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    //    @Override
//    public NeighborUser defaultForAccount(Long accountId) {
//        NeighborUser user = new NeighborUser();
//        user.setUserPhone("0");
//        user.setPinCode("0");//todo ???
//        user.setCreatedOn(new Date());
//        user.setAccountId(accountId);
//        user.setActivationStatus(ActivationStatus.ACTIVE);
//        user.setAccountUrn("0");
//        user.setLogin("0");//todo ???
//        return user;
//    }
}
