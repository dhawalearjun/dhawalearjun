package com.nextsaa.elm.controller;

import org.jboss.logging.Logger;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nextsaa.elm.dto.OfficeDTO;
import com.nextsaa.elm.service.OfficeService;

@RestController
@RequestMapping("/rest/offices")
public class OfficeController {

	private Logger logger = Logger.getLogger(OfficeController.class);

	private OfficeService officeService;

	public OfficeController(final OfficeService officeService) {
		this.officeService = officeService;
	}

	/**
	 * Retrieve all Offices. Http Get method must be specified. Url must be set on -
	 * server-url/base-path/offices The data is returned in JSON format
	 *
	 * @param pageable
	 * @return List of Office in JSON format
	 */
	@GetMapping
	public ResponseEntity<?> retrieveAllOffices(
			@PageableDefault(page = 0, size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable) {

		logger.info("API Return all Office´s");
		return new ResponseEntity<>(officeService.getAllOffices(pageable), HttpStatus.OK);
	}

	/**
	 * Retrieve single Office. Http Get method must be specified. Url must be set on
	 * - server-url/base-path/offices/{id} The data is returned in JSON format
	 *
	 * @param id id of office that we want to retrieve
	 * @return Office in JSON format
	 */
	@GetMapping("/{id}")
	public ResponseEntity<?> retrieveOffice(@PathVariable long id) {

		logger.info("API Return single Office");
		return new ResponseEntity<>(officeService.getOfficeById(id), HttpStatus.OK);
	}

	/**
	 * Create Office branch. Http Post method must be specified. Url must be set on
	 * - server-url/base-path/office The data is returned in JSON format
	 *
	 * @param officeDTO JSON data specifying office to add
	 * @return Created office in JSON format
	 */
	@PostMapping
	public ResponseEntity<?> createOffice(@RequestBody OfficeDTO officeDTO) {

		logger.info("API Return created Office");
		return new ResponseEntity<>(officeService.createOffice(officeDTO), HttpStatus.OK);
	}

	/**
	 * Update Office Http Put method must be specified. Url must be set on -
	 * server-url/base-path/office The data is returned in JSON format
	 *
	 * @param officeDTO JSON data specifying Employee to update
	 * @return updated office in JSON format
	 */
	@PutMapping
	public ResponseEntity<?> updateOffice(@RequestBody OfficeDTO officeDTO) {

		logger.info("API Return updated Office");
		return new ResponseEntity<>(officeService.updateOffice(officeDTO), HttpStatus.OK);
	}
	
	/**
     * Retrieve Offices By branchname.
     * Http Get method must be specified.
     * Url must be set on - server-url/base-path/office-by-branchname
     * The data is returned in JSON format
     *
     * @param pageable
     * @param branchname
     * @return office matching branchname
     */
    @GetMapping("/office-by-branchname")
    public ResponseEntity<?> retrieveAllEmployeesByFullName(@PageableDefault(page = 0, size = 10) Pageable pageable, @RequestParam("branchName") String branchName) {

        logger.info("API Return Office´s By BranchName");
        return new ResponseEntity<>(officeService.getAllOfficesByBranchName(pageable, branchName).getContent(), HttpStatus.OK);
    }
}
