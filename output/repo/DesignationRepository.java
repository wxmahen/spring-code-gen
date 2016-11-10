package com.radicalz.persistence.repo;import org.springframework.data.jpa.repository.JpaRepository;import org.springframework.data.rest.core.annotation.RepositoryRestResource;import com.radicalz.persistence.model.Designation;@RepositoryRestResource(collectionResourceRel = "designations", path = "designations")public interface DesignationRepository extends JpaRepository<Designation, Integer>{}