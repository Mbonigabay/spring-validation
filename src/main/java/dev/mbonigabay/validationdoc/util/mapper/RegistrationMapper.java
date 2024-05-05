package dev.mbonigabay.validationdoc.util.mapper;

import org.mapstruct.Mapper;

import dev.mbonigabay.validationdoc.model.entity.Registration;
import dev.mbonigabay.validationdoc.model.request.RegistrationRequest;

@Mapper(componentModel="spring")
public interface RegistrationMapper {
    Registration requestToEntity(RegistrationRequest registrationRequest);
    RegistrationRequest entityToRequest(Registration registration);
}
