package com.helthplus.springbootstarter.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helthplus.springbootstarter.common.Constant;
import com.helthplus.springbootstarter.domain.DrugBalanceDTO;
import com.helthplus.springbootstarter.domain.ErrorDTO;
import com.helthplus.springbootstarter.domain.InventoryValidationDTO;
import com.helthplus.springbootstarter.domain.MedicineBrandSettingDTO;
import com.helthplus.springbootstarter.domain.PrescribeDrugDTO;
import com.helthplus.springbootstarter.domain.UserValidationDTO;
import com.helthplus.springbootstarter.repositories.DrugBalanceRepository;
import com.helthplus.springbootstarter.repositories.MedicineBrandSettingRepository;

@Service
@Transactional
public class MedicineBrandSettingServiceImpl implements MedicineBrandSettingService {

	@Autowired
	MedicineBrandSettingRepository medicineBrandSettingRepository;
	
	@Autowired
	DrugBalanceRepository drugBalanceRepository;
	
	@Override
	public InventoryValidationDTO createMedicineBrandSetting(MedicineBrandSettingDTO medicineBrandSettingDTO) {
		medicineBrandSettingDTO.setCreateDate(new Date());
		InventoryValidationDTO inventoryValidationDTO = new InventoryValidationDTO();
		ErrorDTO errorDTO = new ErrorDTO();
		int count = medicineBrandSettingRepository.getMedicineSettingByBrand(medicineBrandSettingDTO.getBrandName(),medicineBrandSettingDTO.getClinicId());
		if(count > 0){
			errorDTO.setError(Constant.BRANDNAME_IS_AVAILABLE);
			errorDTO.setMessage(Constant.BRANDNAME_IS_AVAILABLE);
			inventoryValidationDTO.setError(errorDTO);
			inventoryValidationDTO.setStatus(0);
			inventoryValidationDTO.setHttpCode(500);
			return inventoryValidationDTO;
			
		}
		
		MedicineBrandSettingDTO brandSettingDTO =  medicineBrandSettingRepository.save(medicineBrandSettingDTO);

		if(brandSettingDTO != null){
			return getAllMedicineBrandSetting(medicineBrandSettingDTO);
		}else{
			inventoryValidationDTO.setStatus(0);
			inventoryValidationDTO.setHttpCode(500);
			return inventoryValidationDTO;
		}
	}

	@Override
	public InventoryValidationDTO getAllMedicineBrandSetting(MedicineBrandSettingDTO medicineBrandSettingDTO) {
 		InventoryValidationDTO inventoryValidationDTO = new InventoryValidationDTO();
		ErrorDTO error = new ErrorDTO();
		List<MedicineBrandSettingDTO>  list = medicineBrandSettingRepository.getAllMedicineBrandSettingByClinicId(medicineBrandSettingDTO.getClinicId());
		if(list.size() > 0){
			inventoryValidationDTO.setMedicineBrandSettingDTOs(list);
			inventoryValidationDTO.setStatus(1);
			inventoryValidationDTO.setHttpCode(200);
			return inventoryValidationDTO;
		}else{
			error.setError(Constant.INVALIDDATA);
			error.setMessage(Constant.INVALIDDATA);
			inventoryValidationDTO.setStatus(0);
			inventoryValidationDTO.setHttpCode(500);
			inventoryValidationDTO.setError(error);
			return inventoryValidationDTO;
			
		}

	}

	@Override
	public InventoryValidationDTO deleteMedicineBrandSetting(MedicineBrandSettingDTO medicineBrandSettingDTO) {
		InventoryValidationDTO inventoryValidationDTO = new InventoryValidationDTO();
		ErrorDTO error = new ErrorDTO();
		 medicineBrandSettingRepository.deleteById(medicineBrandSettingDTO.getId());
		 inventoryValidationDTO = getAllMedicineBrandSetting(medicineBrandSettingDTO);
			inventoryValidationDTO.setStatus(1);
			inventoryValidationDTO.setHttpCode(200);
			return inventoryValidationDTO;
	}

	@Override
	public InventoryValidationDTO getMedicineBrandSettingById(PrescribeDrugDTO prescribeDrugDTO) {
		InventoryValidationDTO inventoryValidationDTO = new InventoryValidationDTO();
		ErrorDTO error = new ErrorDTO();
		List<MedicineBrandSettingDTO> list = new ArrayList<MedicineBrandSettingDTO>();
		List<DrugBalanceDTO> balanceDTOs = new ArrayList<>();
		MedicineBrandSettingDTO  brandSettingDTO = medicineBrandSettingRepository.getMedicineBrandSettingById(Long.parseLong(prescribeDrugDTO.getDrug()));
		if(brandSettingDTO != null){
			DrugBalanceDTO balanceDTO = null;
			try{
				 balanceDTO =  drugBalanceRepository.findByDrugId(Long.parseLong(prescribeDrugDTO.getDrug()));
				
			}catch(Exception e){
				System.out.println(e);
			}
			list.add(brandSettingDTO);
			balanceDTOs.add(balanceDTO);
			inventoryValidationDTO.setMedicineBrandSettingDTOs(list);
			inventoryValidationDTO.setBalanceDTOs(balanceDTOs);
			inventoryValidationDTO.setStatus(1);
			inventoryValidationDTO.setHttpCode(200);
			return inventoryValidationDTO;
		}else{
			error.setError(Constant.INVALIDDATA);
			error.setMessage(Constant.INVALIDDATA);
			inventoryValidationDTO.setStatus(0);
			inventoryValidationDTO.setHttpCode(500);
			inventoryValidationDTO.setError(error);
			return inventoryValidationDTO;
			
		}

	}
	

}
