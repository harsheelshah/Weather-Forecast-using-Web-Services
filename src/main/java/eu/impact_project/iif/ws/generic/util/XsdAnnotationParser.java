/*
	
	Copyright 2011 The IMPACT Project
	
	@author Dennis Neumann

	Licensed under the Apache License, Version 2.0 (the "License"); 
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at
 
  		http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.

*/
package eu.impact_project.iif.ws.generic.util;

import org.xml.sax.ContentHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.Attributes;

import com.sun.xml.xsom.parser.AnnotationContext;
import com.sun.xml.xsom.parser.AnnotationParser;

public class XsdAnnotationParser extends AnnotationParser {
    private StringBuilder documentation = new StringBuilder();
    @Override
    public ContentHandler getContentHandler(AnnotationContext context,
    String parentElementName, ErrorHandler handler, EntityResolver resolver) {
        return new ContentHandler(){
            private boolean parsingDocumentation = false;
            @Override
            public void characters(char[] ch, int start, int length)
            throws SAXException {
                if(parsingDocumentation){
                    documentation.append(ch,start,length);
                }
            }
            @Override
            public void endElement(String uri, String localName, String name)
            throws SAXException {
                if(localName.equals("documentation")){
                    parsingDocumentation = false;
                }
            }
            @Override
            public void startElement(String uri, String localName,String name,
            Attributes atts) throws SAXException {
                if(localName.equals("documentation")){
                    parsingDocumentation = true;
                }
            }
			@Override
			public void endDocument() throws SAXException {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void endPrefixMapping(String prefix) throws SAXException {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void ignorableWhitespace(char[] ch, int start, int length)
					throws SAXException {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void processingInstruction(String target, String data)
					throws SAXException {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void setDocumentLocator(Locator locator) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void skippedEntity(String name) throws SAXException {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void startDocument() throws SAXException {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void startPrefixMapping(String prefix, String uri)
					throws SAXException {
				// TODO Auto-generated method stub
				
			}
        };
    }
    @Override
    public Object getResult(Object existing) {
        return documentation.toString().trim();
    }
}
