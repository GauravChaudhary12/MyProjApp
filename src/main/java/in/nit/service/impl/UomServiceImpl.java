package in.nit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IUomDao;
import in.nit.model.Uom;
import in.nit.service.IUomService;

@Service
public class UomServiceImpl implements IUomService {

	@Autowired
	private IUomDao dao;
	
	@Transactional
	public Integer saveUom(Uom ob) {
		return dao.saveUom(ob);
	}

}
