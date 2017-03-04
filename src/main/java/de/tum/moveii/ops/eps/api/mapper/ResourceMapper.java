package de.tum.moveii.ops.eps.api.mapper;

/**
 * Created by Constantin Costescu on 04-Mar-17.
 */
interface ResourceMapper<M, R> {
    R toResource(M message);

    M toMessage(R resource);
}
