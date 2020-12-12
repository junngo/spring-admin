package org.junngo.admin.web;

import org.junngo.admin.domain.network.Header;
import org.junngo.admin.web.api.CrudInterface;

public abstract class CrudController<Req, Res> implements CrudInterface<Req, Res> {

    protected CrudInterface<Req, Res> baseService;

    @Override
    public Header<Res> create(Header<Req> request) {
        return baseService.create(request);
    }

    @Override
    public Header<Res> read(Long id) {
        return baseService.read(id);
    }

    @Override
    public Header<Res> update(Header<Req> request) {
        return baseService.update(request);
    }

    @Override
    public Header delete(Long id) {
        return baseService.delete(id);
    }
}
