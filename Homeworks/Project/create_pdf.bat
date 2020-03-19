pandoc  --verbose --toc .\report.md -o final_report.pdf -f markdown+implicit_figures+link_attributes -F mermaid-filter.cmd --mathjax --listings -H listings-setup.tex
