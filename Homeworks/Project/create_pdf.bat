pandoc --toc .\report.md -o final_report.pdf -f markdown+implicit_figures+link_attributes --filter pandoc-mermaid --mathjax --listings -H listings-setup.tex
