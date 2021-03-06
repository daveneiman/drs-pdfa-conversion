/*
Copyright (c) 2016 by The President and Fellows of Harvard College
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License. You may obtain a copy of the License at:
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software distributed under the License is
distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permission and limitations under the License.
*/
package edu.harvard.hul.ois.drs.pdfaconvert.tools;

import java.io.File;

import edu.harvard.hul.ois.drs.pdfaconvert.GeneratedFileUnavailableException;
import edu.harvard.hul.ois.drs.pdfaconvert.PdfaConverterOutput;
import edu.harvard.hul.ois.drs.pdfaconvert.UnknownFileTypeException;

/**
 * Interface for tools that convert an input file to a PDF/A document.
 * 
 * @author dan179
 */
public interface PdfaConvertable {

	/**
	 * Convert the input file to a PDF/A. Converted file remains in configured output directory.
	 * If method not implemented by class then this default implementation will be used.
	 * 
	 * @param inputFile The file to convert.
	 * @return PdfaConverterOutput - Contains the input converted to PDF/A and other relevant data.
	 * @throws GeneratedFileUnavailableException (RuntimeException) - If the generated file is either unavailable or unreadable.
	 * @throws ExternalToolException - When there is a problem with the external tool being executed.
	 * @throws UnknownFileTypeException - The input file cannot be converted to PDF/A.
	 */
	default PdfaConverterOutput convert(File inputFile) {
		String msg = "Cannot process this file type: " + inputFile.getAbsolutePath();
		throw new UnknownFileTypeException(msg);
	};

	/**
	 * Convert the input file to a PDF/A, deleting converted file if requested.
	 * If method not implemented by class then this default implementation will be used.
	 * 
	 * @param inputFile The file to convert.
	 * @param deleteConvertedFile <code>true</code> delete the converted file once returned; <code>false</code> leave 
	 * 			converted file in configured output directory.
	 * @return PdfaConverterOutput - Contains the input converted to PDF/A and other relevant data.
	 * @throws GeneratedFileUnavailableException (RuntimeException) - If the generated file is either unavailable or unreadable.
	 * @throws ExternalToolException - When there is a problem with the external tool being executed.
	 * @throws UnknownFileTypeException - The input file cannot be converted to PDF/A.
	 */
	default PdfaConverterOutput convert(File inputFile, boolean deleteConvertedFile) {
		String msg = "Cannot process this file type: " + inputFile.getAbsolutePath();
		throw new UnknownFileTypeException(msg);
	};

}