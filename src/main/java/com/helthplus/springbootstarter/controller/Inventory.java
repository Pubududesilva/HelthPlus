package com.helthplus.springbootstarter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helthplus.springbootstarter.domain.DoctorDTO;
import com.helthplus.springbootstarter.domain.DrugTypeDTO;
import com.helthplus.springbootstarter.domain.DrugTypeImageDTO;
import com.helthplus.springbootstarter.domain.InventoryValidationDTO;
import com.helthplus.springbootstarter.domain.MedicineBrandNameDTO;
import com.helthplus.springbootstarter.domain.MedicineBrandSettingDTO;
import com.helthplus.springbootstarter.domain.MedicineDTO;
import com.helthplus.springbootstarter.domain.MedicineGenericNameDTO;
import com.helthplus.springbootstarter.domain.PrescribeDrugDTO;
import com.helthplus.springbootstarter.domain.SupplierDTO;
import com.helthplus.springbootstarter.domain.UserValidationDTO;
import com.helthplus.springbootstarter.repositories.MedicineBrandSettingRepository;
import com.helthplus.springbootstarter.services.DrugTypeImageService;
import com.helthplus.springbootstarter.services.DrugTypeService;
import com.helthplus.springbootstarter.services.MedicineBrandNameService;
import com.helthplus.springbootstarter.services.MedicineBrandSettingService;
import com.helthplus.springbootstarter.services.MedicineGenericService;
import com.helthplus.springbootstarter.services.MedicineService;
import com.helthplus.springbootstarter.services.SupplierService;

@RestController
@RequestMapping("api/inventory")
public class Inventory {
	
	@Autowired
	MedicineGenericService medicineGenericService;
	
	@Autowired
	MedicineService medicineService; 
	
	@Autowired
	MedicineBrandSettingService medicineBrandSettingService;
	
	@Autowired
	SupplierService supplierService; 
	
	@Autowired
	DrugTypeService drugTypeService;
	
	@Autowired
	DrugTypeImageService drugTypeImageService;
	
	@Autowired
	MedicineBrandNameService medicineBrandNameService;
	
	@PostMapping("/createmedicinegenericname")
	public ResponseEntity<UserValidationDTO> createGenericName(@RequestBody MedicineGenericNameDTO dto){
		UserValidationDTO userDto = medicineGenericService.createMedicineGeneric(dto);
		 return new ResponseEntity<UserValidationDTO>(userDto,HttpStatus.OK);
	}

	@PostMapping("/getallmedicinegenericnamebyclinicid")
	public ResponseEntity<UserValidationDTO> getAllMedicineGenericNameByClinicId(@RequestBody MedicineGenericNameDTO dto){
		UserValidationDTO userDto = medicineGenericService.getAllMedicineGenericByClinicId(dto);
		 return new ResponseEntity<UserValidationDTO>(userDto,HttpStatus.OK);
	}
	
	@PostMapping("/deletelmedicinegenericnamebyclinicid")
	public ResponseEntity<UserValidationDTO> deleteMedicineGenericNameById(@RequestBody MedicineGenericNameDTO dto){
		UserValidationDTO userDto = medicineGenericService.deleteMedicineGenericById(dto);
		 return new ResponseEntity<UserValidationDTO>(userDto,HttpStatus.OK);
	}
	
	@PostMapping("/createmedicine")
	public ResponseEntity<UserValidationDTO> createMedicine(@RequestBody MedicineDTO dto){
		UserValidationDTO userDto = medicineService.createMedicine(dto);
		 return new ResponseEntity<UserValidationDTO>(userDto,HttpStatus.OK);
	}
	
	@PostMapping("/createMedicinebrandsetting")
	public ResponseEntity<InventoryValidationDTO> createMedicineBrandSetting(@RequestBody MedicineBrandSettingDTO dto){
		InventoryValidationDTO userDto = medicineBrandSettingService.createMedicineBrandSetting(dto);
		 return new ResponseEntity<InventoryValidationDTO>(userDto,HttpStatus.OK);
	}
	
	@PostMapping("/getAllMedicinebrandsetting")
	public ResponseEntity<InventoryValidationDTO> getAllMedicineBrandSetting(@RequestBody MedicineBrandSettingDTO dto){
		InventoryValidationDTO userDto = medicineBrandSettingService.getAllMedicineBrandSetting(dto);
		 return new ResponseEntity<InventoryValidationDTO>(userDto,HttpStatus.OK);
	}
	
	@PostMapping("/getMedicinebrandsettingById")
	public ResponseEntity<InventoryValidationDTO> getMedicinebrandsettingById(@RequestBody PrescribeDrugDTO dto){
		InventoryValidationDTO userDto = medicineBrandSettingService.getMedicineBrandSettingById(dto);
		 return new ResponseEntity<InventoryValidationDTO>(userDto,HttpStatus.OK);
	}
	
	@PostMapping("/deleteMedicinebrandsetting")
	public ResponseEntity<InventoryValidationDTO> deleteMedicineBrandSetting(@RequestBody MedicineBrandSettingDTO dto){
		InventoryValidationDTO userDto = medicineBrandSettingService.deleteMedicineBrandSetting(dto);
		 return new ResponseEntity<InventoryValidationDTO>(userDto,HttpStatus.OK);
	}
	
	@PostMapping("/createSupplier")
	public ResponseEntity<InventoryValidationDTO> createSupplier(@RequestBody SupplierDTO dto){
		InventoryValidationDTO userDto = supplierService.createSupplier(dto);
		 return new ResponseEntity<InventoryValidationDTO>(userDto,HttpStatus.OK);
	}
	
	@PostMapping("/getAllSupplier")
	public ResponseEntity<InventoryValidationDTO> getAllSupplier(@RequestBody SupplierDTO dto){
		InventoryValidationDTO userDto = supplierService.getAllSupplier(dto);
		 return new ResponseEntity<InventoryValidationDTO>(userDto,HttpStatus.OK);
	}
	
	@PostMapping("/deleteSupplier")
	public ResponseEntity<InventoryValidationDTO> deleteSupplier(@RequestBody SupplierDTO dto){
		InventoryValidationDTO userDto = supplierService.deleteSupplier(dto);
		 return new ResponseEntity<InventoryValidationDTO>(userDto,HttpStatus.OK);
	}
	
	@PostMapping("/createdrugtype")
	public ResponseEntity<InventoryValidationDTO> createDrugType(@RequestBody DrugTypeDTO dto){
		InventoryValidationDTO userDto = drugTypeService.createDrugType(dto);
		 return new ResponseEntity<InventoryValidationDTO>(userDto,HttpStatus.OK);
	}
	
	@PostMapping("/getalldrugtype")
	public ResponseEntity<InventoryValidationDTO> getAllDrugType(@RequestBody DrugTypeDTO dto){
		InventoryValidationDTO userDto = drugTypeService.getAllDrugType(dto);
		 return new ResponseEntity<InventoryValidationDTO>(userDto,HttpStatus.OK);
	}
	
	@PostMapping("/deletedrugtype")
	public ResponseEntity<InventoryValidationDTO> deleteDrugType(@RequestBody DrugTypeDTO dto){
		InventoryValidationDTO userDto = drugTypeService.deleteDrugType(dto);
		 return new ResponseEntity<InventoryValidationDTO>(userDto,HttpStatus.OK);
	}
	
	@PostMapping("/getalldrugtypeImage")
	public ResponseEntity<InventoryValidationDTO> getAllDrugTypeImage(@RequestBody DrugTypeDTO dto){
		InventoryValidationDTO userDto = drugTypeImageService.getAllDrugTypeImage();
		 return new ResponseEntity<InventoryValidationDTO>(userDto,HttpStatus.OK);
	}
	
	@PostMapping("/createdrugtypeImage")
	public ResponseEntity<InventoryValidationDTO> createDrugTypeImage(DrugTypeImageDTO dto){
		InventoryValidationDTO userDto = drugTypeImageService.createTypeImage(dto);
		 return new ResponseEntity<InventoryValidationDTO>(userDto,HttpStatus.OK);
	}
	
	@PostMapping("/deletemediclebrandname")
	public ResponseEntity<InventoryValidationDTO> deleteMedicleBrandName(@RequestBody MedicineBrandNameDTO dto){
		InventoryValidationDTO userDto = medicineBrandNameService.deleteMedicineBrandName(dto);
		 return new ResponseEntity<InventoryValidationDTO>(userDto,HttpStatus.OK);
	}
	
	@PostMapping("/createmediclebrandname")
	public ResponseEntity<InventoryValidationDTO> createMedicleBrandName(@RequestBody MedicineBrandNameDTO dto){
		InventoryValidationDTO userDto = medicineBrandNameService.createMedicineBrandName(dto);
		 return new ResponseEntity<InventoryValidationDTO>(userDto,HttpStatus.OK);
	}
	
	@PostMapping("/getallmediclebrandname")
	public ResponseEntity<InventoryValidationDTO> getAllMedicleBrandName(@RequestBody MedicineBrandNameDTO dto){
		InventoryValidationDTO userDto = medicineBrandNameService.getAllMedicineBrandName(dto);
		 return new ResponseEntity<InventoryValidationDTO>(userDto,HttpStatus.OK);
	}
}
